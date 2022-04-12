using System;
using System.Collections.Generic;

namespace Students.Data.Models
{
    public class Group
    {
        public Guid Id { get; set; }
        public Guid SpecialtyId { get; set; }
        public string Name { get; set; }
        public List<Student> Students { get; set; }
    }
}
