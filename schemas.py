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
    first_name: str
    second_name: str
    IsExpelled: bool


class StudentInfo((BaseModel)):
    id: int
    first_name: str
    second_name: str
    IsExpelled: bool

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