using Students.Data.Models;
using System;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Students.Data.Repositories.Abstracts
{
    public interface IStudentRepository
    {
        Task<List<Student>> GetStudentsAsync();
        Task<Student> GetStudentByIdAsync(Guid id);
        Task<Student> CreateAsync(Student student);
    }
}
