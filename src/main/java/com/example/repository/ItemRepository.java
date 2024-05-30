package com.example.repository;

import com.example.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Itemsテーブルを操作するリポジトリです.
 *
 * @author haruka.yamaneki 
 */

@Repository
public class ItemRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    /**
     * Itemオブジェクトを生成するRowMapperです.
     * テーブルから値を取り出してオブジェクトに入れる。
     */
    private static final RowMapper<Item> ITEM_ROW_MAPPER = (rs, i) -> {
        Item item = new Item();
        item.setId(rs.getInt("id"));
        item.setName(rs.getString("name"));
        item.setProductionArea(rs.getString("production_area"));
        item.setImage(rs.getString("image"));
        item.setPrice(rs.getString("price"));
        item.setComment(rs.getString("comment"));
        return item;
    };


    /**
     * 商品一覧情報をid(昇順で)取得します.
     * (商品が存在しない場合にはサイズ０件の商品一覧を返します)
     *
     * @return 商品情報
     */
    public List<Item> findALl() {
        String sql = "SELECT id,name,production_area,image,price,comment FROM alcohol_items ORDER BY id;";
        return template.query(sql, ITEM_ROW_MAPPER);
    }

    /**
     * 主キーから商品情報を取得します.
     *
     * @param id ID
     * @return 商品情報
     */
    public Item load(Integer id) {
        String sql = "SELECT id,name,production_area,image,price,comment FROM alcohol_items WHERE id=:id;";
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
        return template.queryForObject(sql, param, ITEM_ROW_MAPPER);
    }

    /**
     * 商品情報を更新します.
     *
     * @param item 商品情報
     */
    public void update(Item item) {
        String sql = "UPDATE item SET id=:id,name=:name,production_area=:production_area,image=:image,price=:price,comment=:comment;";
        SqlParameterSource param = new BeanPropertySqlParameterSource(item);
        template.update(sql, param);
    }

}
