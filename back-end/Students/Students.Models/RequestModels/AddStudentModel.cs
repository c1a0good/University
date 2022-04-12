using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Students.Models.RequestModels
{
    public class AddStudentModel
    {
        [Required]
        public string FirstName { get; set; }
        [Required]
        public string SecondName { get; set; }
        [Required]
        public Guid GroupId { get; set; }
        [Required]
        public int Semester { get; set; }
        [Required]
        public bool IsExpelled { get; set; }
        [Required]
        public bool IsDormitory { get; set; }

    }
}
