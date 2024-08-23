package Bai_03.presentation;

import Bai_03.business.entity.Book;
import Bai_03.business.entity.Category;
import Bai_03.business.feature.IBookFeature;
import Bai_03.business.feature.Impl.BookFeatureImpl;
import Bai_03.business.feature.Impl.CateFeatureImpl;

import java.util.Scanner;

public class Main
{
	IBookFeature bookFeature = new BookFeatureImpl();
//	static
//	{
//		Category horror = new Category(1, "Horror", true);
//		Category ecchi = new Category(2, "Ecchi", true);
//		CateFeatureImpl.categories.add(horror);
//		CateFeatureImpl.categories.add(ecchi);
//
//		Book tutien = new Book("B001", "song tu", "Dương Dolce", 2024, "tu tien kiem hiep", ecchi);
//		Book tayduky = new Book("B002", "black myth wukong", "Linh chi", 2020, "Doãn chí bình", horror);
//		Book thandieudaihiep = new Book("B003", "CoCo", "Kim dung", 2020, "Doãn chí bình", horror);
//		BookFeatureImpl.books.add(tutien);
//		BookFeatureImpl.books.add(tayduky);
//		BookFeatureImpl.books.add(thandieudaihiep);
//	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Main main = new Main();
		do
		{
			System.out.println("======= MENU =======");
			System.out.println("""
					      1. Thống kê thể loại và số sách có trong mỗi thể loại
					      2. Hiển thị danh sách sách theo nhóm thể loại
					      3. Thoát
					  """);
			System.out.println("Lựa chọn đê: ");
			int choice = Integer.parseInt(sc.nextLine());
			switch (choice)
			{
				case 1:
				{
					main.statisticsBookByCategory();
					break;
				}
				case 2:
				{
					main.showBookGroupByCategory();
					break;
				}
				case 3:
				{
					System.exit(0);
				}
				default:
					System.err.println("Vui lòng nhập lại từ 1 đến 3");
			}
		}
		while (true);
	}
	
	public void statisticsBookByCategory()
	{
		// kinh dị -> 5 book
		// ecchi -> 2 book
		// harem -> 1 book
		for (Category c : CateFeatureImpl.categories)
		{
			int count = 0;
			for (Book b : BookFeatureImpl.books)
			{
				if (c.getId() == b.getCategories().getId())
				{
					count++;
				}
			}
			System.out.printf("Danh mục %s có số lượng sách = %d\n", c.getName(), count);
		}
	}
	
	public void showBookGroupByCategory()
	{
		// lặp qua categories
		for (Category c : CateFeatureImpl.categories)
		{
			System.out.println("Danh mục: " + c.getName());
			for (Book b : BookFeatureImpl.books)
			{
				if (c.getId() == b.getCategories().getId())
				{
					System.out.println("\tSách: " + b.getTitle());
				}
			}
		}
	}
	
}
