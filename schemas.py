from typing import List, Optional

from pydantic import BaseModel, EmailStr, validator


class StudentBase(BaseModel):
    id: int
    first_name:str
    second_name:str

    class Config:
        orm_mode = True


class StudentServer(BaseModel):
    id: int
    firstName: str
    secondName: str
    isExpelled: bool
    specialtyId:int
    course: int

class StudentInfo((BaseModel)):
    id: int
    firstName: str
    secondName: str
    isExpelled: bool
    course:int

class UserBase(BaseModel):
    username:str

class UserLogIn(UserBase):
    password:str

class UserCreate(UserBase):
    password: str

class User(UserBase):
    id: int
    is_active: bool

    class Config:
        orm_mode = True