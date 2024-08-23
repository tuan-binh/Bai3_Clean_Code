package Bai_03.business.feature.Impl;

import Bai_03.business.entity.Book;
import Bai_03.business.entity.Category;
import Bai_03.business.feature.IBookFeature;

import java.util.ArrayList;
import java.util.List;

public class BookFeatureImpl implements IBookFeature
{
	public static List<Book> books = new ArrayList<>();
	
	static
	{
		Category horror = new Category(1, "Horror", true);
		Category ecchi = new Category(2, "Ecchi", true);
		CateFeatureImpl.categories.add(horror);
		CateFeatureImpl.categories.add(ecchi);
		
		Book tutien = new Book("B001", "song tu", "Dương Dolce", 2024, "tu tien kiem hiep", ecchi);
		Book tayduky = new Book("B002", "black myth wukong", "Linh chi", 2020, "Doãn chí bình", horror);
		Book thandieudaihiep = new Book("B003", "CoCo", "Kim dung", 2020, "Doãn chí bình", horror);
		books.add(tutien);
		books.add(tayduky);
		books.add(thandieudaihiep);
	}
}
