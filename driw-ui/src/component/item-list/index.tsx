import axios from "axios";
import { useEffect, useState } from "react";
import ItemCard from "../item-card";

interface Item {
  id: number;
  name: string;
  cartonPrice: number;
}

export default function ItemList() {
  const [items, setItems] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:8000/item")
      .then((response) => {
        setItems(response.data);
      })
      .catch((err) => {
        setItems([]);
        console.error(err);
      });
  });

  return (
    <div className="container" id="body">
      <div className="col-12">
        <div className="row">
          {items.map((item: Item) => (
            <ItemCard
              id={item.id}
              cartonPrice={item.cartonPrice}
              name={item.name}
              key={item.id}
            ></ItemCard>
          ))}
        </div>
      </div>
    </div>
  );
}
