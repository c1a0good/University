using System;
using System.ComponentModel.DataAnnotations;

namespace Students.Data.Models
{
    public class Marks
    {
        [Key]
        public Guid StudentId { get; set; }
        public Guid DisciplineId { get; set; }
        public int Mark { get; set; }
        public enum MarkType
        {
            test,
            exam
        }
        public Student Student { get; set; }
    }
}
