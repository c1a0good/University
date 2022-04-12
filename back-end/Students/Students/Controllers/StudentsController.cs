using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Students.Data.Repositories.Abstracts;
using Students.Models.RequestModels;
using System;
using System.Threading.Tasks;

namespace Students.Controllers
{
    [Route("api/students")]
    [ApiController]
    public class StudentsController : ControllerBase
    {
        private readonly IStudentRepository _studentRepository;
        public StudentsController(IStudentRepository studentRepository)
        {
            _studentRepository = studentRepository;
        }

        [HttpGet]
        public async Task<IActionResult> GetStudentsAsync()
        {
            var students = await _studentRepository.GetStudentsAsync();
            return Ok(students);
        }

        [HttpGet("{id}")]
        public async Task<IActionResult> GetStudentByIdAsync([FromRoute]Guid id)
        {
            var student = await _studentRepository.GetStudentByIdAsync(id);
            return Ok(student);
        }

        [HttpPost]
        /*public Task<IActionResult> AddStudentAsync([FromBody] AddStudentModel model)
        {
            return Ok(model);
        }*/

        [HttpPut("{id}")]
        public Task<IActionResult> UpdateStudent(Guid id)
        {
            throw new NotImplementedException();
        }
    }
}
