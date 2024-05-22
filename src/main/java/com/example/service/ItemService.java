package com.example.service;


import com.example.domain.Item;
import com.example.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
/**
 * 商品一覧を検索するメソッドがあるクラスです.
 *
 * @author haruka.yamaneki
 */
@Service
@Transactional
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    /**
     * 商品一覧を出力する.
     *
     * @return 商品一覧
     */
    public List<Item> showList(){
        return itemRepository.findALl();
    }

    /**
     * 従業員情報を取得する
     * @param id ID
     * @return 従業員情報
     */
    public Item showload(Integer id){
        return itemRepository.load(id);
    }

//    public void uodate(){
//
//    }

}
