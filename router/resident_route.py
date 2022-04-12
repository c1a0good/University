from typing import List

import pydantic
from fastapi import APIRouter, Depends, HTTPException, File, Body

from dependencie import get_current_user, student_id
from repository.students import StudentRepository
from schemas import StudentBase, StudentInfo

router = APIRouter(
    prefix="/residents",
    tags=["residents"],
)

@router.get('/',response_model=List[StudentBase])
async def list_of_student(repository:StudentRepository=Depends(),user: str = Depends(get_current_user)):
    residents=repository.all()
    return residents

@router.delete('/{id}')
async def del_resident(id:int,user: str = Depends(get_current_user),repository:StudentRepository=Depends()):
    students = [stud.id for stud in repository.all()]
    if id not in students:
        raise HTTPException(status_code=404, detail="Bad request")
    del_resident=repository.delete_student(id)
    return del_resident

@router.post('/{id}',response_model=StudentBase)
async def add_resident(student: dict = Depends(student_id),user: str = Depends(get_current_user),repository:StudentRepository=Depends()):
    students = [stud.id for stud in repository.all()]
    print(students)
    try:
        student = StudentBase(**student)
    except pydantic.error_wrappers.ValidationError:
        raise HTTPException(status_code=505, detail="Bad data")
    if student.id in students:
        raise HTTPException(status_code=404, detail="this resident is already exist")
    print(student)
    repository.create_BaseStudent(student)
    return student