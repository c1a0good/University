using System;
using System.Collections.Generic;

namespace Students.Data.Models
{
    public class Student
    {
        public Guid Id { get; set; }
        public string FirstName { get; set; }
        public string SecondName { get; set; }
        public Guid GroupId { get; set; }
        public int Semester { get; set; }
        public bool IsExpelled { get; set; }
        public bool IsDormitory { get; set; }
        public Group Group { get; set; }
        public List<Marks> StudentMarks { get; set; }
    }
}

//отчислен/нет?

//статус