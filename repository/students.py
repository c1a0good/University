from typing import List
from uuid import UUID

from fastapi.params import Depends
from pydantic import EmailStr
from sqlalchemy.orm import Session

from models import Student

from dependencie import get_db
from schemas import StudentBase, StudentServer


class StudentRepository:
    def __init__(self, db: Session = Depends(get_db)):
        self.db = db  # произойдет внедрение зависимостей

    def find_by_id(self, id: int):
        query = self.db.query(Student)
        return query.filter(Student.id == id).first()

    def all(self, skip: int = 0) -> List[Student]:
        query = self.db.query(Student)
        return query.offset(skip).all()

    def delete_student(self, id: int)->StudentBase:
        query = self.db.query(Student)
        return query.filter(Student.id == id).delete()

    def create(self, id: int,first_name: str, second_name:str) -> Student:
        db_user = Student(  # **user.dict()
            id=id,
            first_name=first_name,
            second_name=second_name
        )

        self.db.add(db_user)
        self.db.commit()
        self.db.refresh(db_user)

        return db_user

    def create_BaseStudent(self,resident:StudentBase):
        db_user = Student(  # **user.dict()
            id=resident.id,
            first_name=resident.first_name,
            second_name=resident.second_name
        )

        self.db.add(db_user)
        self.db.commit()
        self.db.refresh(db_user)

        return db_user

