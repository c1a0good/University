from typing import List

from fastapi import APIRouter, Depends, HTTPException, File, Body
import os
import pydantic
import hashlib

import repository
from dependencie import student_list, student_id, get_current_user
from repository.students import StudentRepository
from schemas import StudentServer, StudentBase, StudentInfo

router = APIRouter(
    prefix="/students",
    tags=["students"],
)


########################################### Возврат значений с сервера
@router.get('/server/{id}')
async def stud_info(id: int):
    return {'id': id,'first_name':'Ilia','second_name':'Shmur','IsExpelled': False}  # ,'passport':135827737293}


@router.get('/list')
async def list_of_student():
    #list_ = [{'id': 4, 'status': 'expelled'}, {'id': 5, 'status': 'enroled'}, {'id': 6, 'status': 'enroled'}]
    return [{'id': 4,'first_name':'Ilia','second_name':'Shmur','IsExpelled': False}, {'id': 5, 'first_name':'Ilia','second_name':'Shmur','IsExpelled': False},{'id': 10,'first_name':'Ilia','second_name':'Shmur', 'IsExpelled': False}]


################################################
@router.get('/')
async def fired_student(students_server: List[StudentServer] = Depends(student_list),
                        repositor: StudentRepository = Depends(),user: str = Depends(get_current_user)):
    students = [stud.id for stud in repositor.all()]

    list_ex = []
    for s in students_server:
        try:
            s = StudentServer(**s)
        except pydantic.error_wrappers.ValidationError:
            raise HTTPException(status_code=505, detail="Bad data")
        if s.IsExpelled and s.id in students:
            repositor.delete_student(s.id)
            list_ex.append(s.id)
    return {"expelled students": list_ex}


@router.get('/{id}')
async def student_info(student: dict = Depends(student_id),user: str = Depends(get_current_user)):
    print(student)
    try:
        student = StudentInfo(**student)
    except pydantic.error_wrappers.ValidationError:
        raise HTTPException(status_code=505, detail="Bad data")


    return student
