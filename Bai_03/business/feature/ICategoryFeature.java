package Bai_03.business.feature;

import Bai_03.business.entity.Category;

public interface ICategoryFeature {

    void sortByNameCate();
    void addCategory( Category category );
    void removeCategory( int idDelete);
    void updateCategory( Category category, int idUpdate );
    void quantityBook( Category category);

}
