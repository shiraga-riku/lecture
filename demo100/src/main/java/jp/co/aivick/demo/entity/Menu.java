package jp.co.aivick.demo.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity(immutable = true)
@Table(name = "menu")
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	final private Integer id;

	@Column(name = "name")
	final private String name;

	@Column(name = "type")
	final private String type;

	@Column(name = "price")
	final private Integer price;
	
	public Menu(Integer id,String name,String type,Integer price) {
		this.id=id;
		this.name=name;
		this.type=type;
		this.price=price;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public Integer getPrice() {
		return price;
	}


}
