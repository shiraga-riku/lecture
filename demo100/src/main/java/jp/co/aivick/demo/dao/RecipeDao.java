package jp.co.aivick.demo.dao;

import java.util.List;
import jp.co.aivick.demo.entity.Recipe;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;

@ConfigAutowireable
@Dao
public interface RecipeDao
{
    @Select
    Recipe find(String id);

    @Select
    List<Recipe> findAll();

    @Insert
    int insert(Recipe recipe);

    @Update
    int update(Recipe recipe);
}
