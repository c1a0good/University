using Microsoft.EntityFrameworkCore;
using Students.Data.Models;
using System;

namespace Students.Data
{
    public class StudentsContext : DbContext
    {
        public DbSet<Student> Students { get; set; }
        public DbSet<Group> Groups { get; set; }
        public DbSet<Marks> Marks { get; set; }

        public StudentsContext(DbContextOptions<StudentsContext> options) : base(options)
        {

        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {

        }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlServer(@"Server=(localdb)\mssqllocaldb;Database=Students;Trusted_Connection=True");
            optionsBuilder.LogTo(Console.WriteLine);
        }
    }
}
