using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using Blog.Data;
using Blog.Models;
using Microsoft.AspNetCore.Authorization;

namespace Blog.Controllers
{
    public class ArticleController : Controller
    {
        private readonly ApplicationDbContext _context;

        public ArticleController(ApplicationDbContext context)
        {
            _context = context;
        }


        // GET: Article
        public ActionResult Index()
        {
            return RedirectToAction("List");
        }

        //
        //GET: Article/List
        public ActionResult List()
        {
            var articles = _context.Articles
                .Include(a => a.Author)
                .ToList();
            return View(articles);
        }

        // GET: Article/Details
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return StatusCode(500);
            }

            var article = _context.Articles
                .Include(a => a.Author)
                .SingleOrDefaultAsync(m => m.Id == id);

            if (article == null)
            {
                return StatusCode(500);
            }

            return View(article);
        }

        // GET: Article/Create
        [Authorize]
        public IActionResult Create()
        {
            ViewData["AuthorId"] = new SelectList(_context.Users, "Id", "Id");
            return View();
        }

        // POST: Article/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [Authorize]
        public ActionResult Create(Article article)
        {
            if (ModelState.IsValid)
            {
                //get User id
                var authorId = _context.Users
                    .Where(u => u.UserName == this.User.Identity.Name)
                    .First()
                    .Id;
                //set article author
                article.AuthorId = authorId;
                //save article
                _context.Articles.Add(article);
                _context.SaveChanges();

                return RedirectToAction("Index");
            }
            return View(article);
        }

        // GET: Article/Edit
        public IActionResult Edit(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            //Get article from database 
            var article = _context.Articles
                .Where(x => x.Id == id)
                .First();
            //Check if article exists
            if (article == null)
            {
                return NotFound();
            }
            //Create the view model
            var model = new ArticleViewModel();
            model.Id = article.Id;
            model.Title = article.Title;
            model.Content = article.Content;
            //pass the model to view 

            return View(model);
        }

        // POST: Article/Edit
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        public ActionResult Edit(ArticleViewModel model)
        {
            if (ModelState.IsValid)
            {
                var article = _context.Articles
                    .FirstOrDefault(a => a.Id == model.Id);

                article.Title = model.Title;
                article.Content = model.Content;

                _context.Update(article);
                _context.SaveChanges();

                return RedirectToAction("Index");
            }
            return View(model);
        }

        // GET: Article/Delete
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var article = _context.Articles
                .First(m => m.Id == id);
            if (article == null)
            {
                return StatusCode(500);
            }

            return View(article);
        }

        // POST: Article/Delete
        [HttpPost, ActionName("Delete")]
        public ActionResult DeleteConfirmed(int id)
        {
            //Get Article
            var article = _context.Articles
                .Include(a => a.Author)
                .First(m => m.Id == id);
            //Check if article exist
            if (article == null)

            {
                return NotFound();
            }
            //Delete article
            _context.Articles.Remove(article);
            _context.SaveChanges();

            //Redirect to Index
            return RedirectToAction("Index");

        }

        private bool ArticleExists(int id)
        {
            return _context.Articles.Any(e => e.Id == id);
        }
        private bool IsUserAuthorizedToEdit(Article article)
        {
            bool isAdmin = this.User.IsInRole("Admin");
            bool isAuthor = article.IsAuthor(this.User.Identity.Name);

            return isAdmin || isAuthor;
        }
    }
}
