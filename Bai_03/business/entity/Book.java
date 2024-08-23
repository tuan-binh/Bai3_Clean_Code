package Bai_03.business.entity;

import Bai_03.business.feature.Impl.BookFeatureImpl;
import Bai_03.business.feature.Impl.CateFeatureImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Book
{
	
	private String idBook;
	private String title;
	private String author;
	private int year;
	private String description;
	private Category categories;
	
	public Book()
	{
	}
	
	public Book(String idBook, String title, String author, int year, String description, Category categories)
	{
		this.idBook = idBook;
		this.title = title;
		this.author = author;
		this.year = year;
		this.description = description;
		this.categories = categories;
	}
	
	public String getIdBook()
	{
		return idBook;
	}
	
	public void setIdBook(String idBook)
	{
		this.idBook = idBook;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getAuthor()
	{
		return author;
	}
	
	public void setAuthor(String author)
	{
		this.author = author;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public void setYear(int year)
	{
		this.year = year;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public Category getCategories()
	{
		return categories;
	}
	
	public void setCategories(Category categories)
	{
		this.categories = categories;
	}
	
	public void inputData(Scanner sc)
	{
		this.idBook = inputIdBook(sc, BookFeatureImpl.books);
		this.title = inputTitle(sc, BookFeatureImpl.books);
		this.author = inputAuthor(sc);
		this.year = inputYear(sc);
		this.description = inputDesc(sc);
		this.categories = inputCate(sc, CateFeatureImpl.categories);
	}
	
	public Category inputCate(Scanner sc, List<Category> categories)
	{
		for (Category c : categories)
		{
			System.out.println(c);
		}
		
		System.out.println("Nhập id danh mục: ");
		do
		{
			int id = Integer.parseInt(sc.nextLine());
			Category check = null;
			for (Category c : categories)
			{
				if (c.getId() == id)
				{
					check = c;
				}
			}
			if (check == null)
			{
				System.err.println("Không tồn tại id danh mục");
			}
			else
			{
				return check;
			}
		}
		while (true);
	}
	
	public String inputDesc(Scanner sc)
	{
		System.out.println("Nhập mô tả sách: ");
		do
		{
			String desc = sc.nextLine();
			if (desc.isEmpty())
			{
				System.err.println("Mô tả không được để trống...");
			}
			else
			{
				return desc;
			}
		}
		while (true);
	}
	
	public int inputYear(Scanner sc)
	{
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		System.out.println("Nhập năm xuất bản: ");
		do
		{
			int year = Integer.parseInt(sc.nextLine());
			if (year >= 1970 && year <= currentYear)
			{
				return year;
			}
			else
			{
				System.err.println("Năm xuất bản từ 1970 - năm hiện tại. ");
			}
		}
		while (true);
	}
	
	public String inputAuthor(Scanner sc)
	{
		System.out.println("Nhập tác giả: ");
		do
		{
			String author = sc.nextLine();
			if (author.isEmpty())
			{
				System.err.println("Tác giả không được để trống");
			}
			else
			{
				return author;
			}
		}
		while (true);
	}
	
	public String inputTitle(Scanner sc, List<Book> books)
	{
		System.out.println("Nhập tiêu đề sách: ");
		do
		{
			String title = sc.nextLine();
			if (title.length() >= 6 && title.length() <= 50)
			{
				boolean check = false;
				for (Book book : books)
				{
					if (title.equals(book.getTitle()))
					{
						System.err.println("Tiêu đề đã tồn tại...");
						check = true;
						break;
					}
				}
				if (!check)
				{
					return title;
				}
			}
			else
			{
				System.err.println("Tiêu đề từ 6-50 ký tự");
			}
		}
		while (true);
	}
	
	public String inputIdBook(Scanner sc, List<Book> books)
	{
		System.out.println("Nhập id sách: ");
		do
		{
			String idBook = sc.nextLine();
			if (idBook.matches("^B\\w{3}"))
			{
				boolean check = false;
				for (Book book : books)
				{
					if (book.getIdBook().equals(idBook))
					{
						System.err.println("Id sách đã tồn tại...");
						check = true;
						break;
					}
				}
				if (!check)
				{
					return idBook;
				}
			}
			else
			{
				System.err.println("Mã sách phải bắt đầu bằng 'B' và có 4 ký tự.");
			}
		}
		while (true);
	}
	
	public void displayData(List<Category> categories)
	{
		System.out.printf("[ idBook = %s | title = %s | author = %s | year = %s | description = %s ] \n",
				  this.idBook,
				  this.title,
				  this.author,
				  this.year,
				  this.description,
				  nameCateByBook(categories)
		);
	}
	
	public Object nameCateByBook(List<Category> categories)
	{
		for (Category cate : categories)
		{
			if (cate.getId() == this.categories.getId())
			{
				return cate.getName();
			}
		}
		return null;
	}
}
