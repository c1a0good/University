using Microsoft.EntityFrameworkCore;
using Students.Data.Models;
using Students.Data.Repositories.Abstracts;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Students.Data.Repositories
{
    public class StudentRepository : IStudentRepository
    {
        private readonly StudentsContext _context;
        public StudentRepository(StudentsContext context)
        {
            _context = context;
        }

        public Task<Student> CreateAsync(Student student)
        {
            throw new ArgumentNullException(nameof(student));
        }

        public async Task<Student> GetStudentByIdAsync(Guid id)
            => await _context.Students
            .Include(s=>s.Group)
            .Include(s=>s.StudentMarks)
            .Where(s=>s.Id == id).FirstOrDefaultAsync();

        public async Task<List<Student>> GetStudentsAsync()
            => await _context.Students
            .Include(s => s.Group)
            .Include(s=>s.StudentMarks)
            .ToListAsync();
    }
}
