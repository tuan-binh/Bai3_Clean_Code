package Bai_03.business.entity;

import Bai_03.business.feature.Impl.CateFeatureImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Category
{
	private int id;
	private String name;
	private boolean status;
	private Category parent;
	
	// 1. Quần
	//    1.1 Quàn dài
	//    1.2 Quần short
	// 2. Áo
	//    2.1 Áo dài
	//    2.2 T shirt
	//       2.2.1 Áo hoa hòe
	public Category()
	{
	}
	
	public Category(int id, String name, boolean status)
	{
		this.id = id;
		this.name = name;
		this.status = status;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public boolean isStatus()
	{
		return status;
	}
	
	public void setStatus(boolean status)
	{
		this.status = status;
	}
	
	public void inputData(Scanner sc)
	{
		this.id = inputIdCate(CateFeatureImpl.categories);
		this.name = inputNameCate(sc, CateFeatureImpl.categories);
		this.status = inputStatusCate(sc);
	}
	
	private boolean inputStatusCate(Scanner sc)
	{
		System.out.println("Nhập trạng thái danh mục: ");
		do
		{
			String status = sc.nextLine();
			if (status.equalsIgnoreCase("true") || status.equalsIgnoreCase("false"))
			{
				return Boolean.parseBoolean(status);
			}
			else
			{
				System.err.println("Vui lòng nhập true/false");
			}
		}
		while (true);
	}
	
	private String inputNameCate(Scanner sc, List<Category> categories)
	{
		System.out.println("Nhập tên category: ");
		do
		{
			String nameCate = sc.nextLine();
			if (nameCate.length() >= 6 && nameCate.length() <= 30)
			{
				boolean check = false;
				for (Category category : categories)
				{
					if (nameCate.equals(category.getName()))
					{
						System.err.println("Tên danh mục đã tồn tại...");
						check = true;
						break;
					}
				}
				if (!check)
				{
					return nameCate;
				}
			}
			else
			{
				System.err.println("Tên danh mục từ 6-30 ký tự");
			}
		}
		while (true);
	}
	
	private int inputIdCate(List<Category> categories)
	{
		int idMax = 0;
		for (Category category : categories)
		{
			if (category.getId() > idMax)
			{
				idMax = category.getId();
			}
		}
		return idMax + 1;
	}
	
	
	public void displayData()
	{
		System.out.printf("[ Id: %d, Name: %s, Status: %s]\n",
				  this.id,
				  this.name,
				  this.status ? "Hoạt động" : "Không hoạt động");
	}
}
