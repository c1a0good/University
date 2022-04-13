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
        if s.isExpelled and s.id in students:
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
