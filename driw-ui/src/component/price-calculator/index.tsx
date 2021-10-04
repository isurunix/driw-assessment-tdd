import axios from "axios";
import { useEffect, useState } from "react";
import { Item } from "../item-list";
import { ItemPrice } from "../price-table";

export default function PriceCalculator() {
  const [items, setItems] = useState(Array<Item>());
  const [selectedItemId, setSelectedItemId] = useState(0);
  const [qty, setQty] = useState("");
  const [price, setPrice] = useState(0);

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

  function calculatePrice() {
    axios
      .get("http://localhost:8000/item/" + selectedItemId + "/price?qty=" + qty)
      .then((response) => {
          let itemPrice: ItemPrice = response.data;
        setPrice(itemPrice.price);
      })
      .catch((err) => {
        console.error(err);
      });
  }

  return (
    <div className="container" id="body">
      <p>Price Calculator</p>
      <div className="row" style={{ paddingTop: "10px" }}>
        <div className="col">
          <label className="form-label">Item</label>
          <select
            id="inputState"
            className="form-select"
            onChange={(e) => setSelectedItemId(Number(e.target.value))}
          >
            <option value={0}>Select Item</option>
            {items.map((item) => (
              <option value={item.id}>{item.name}</option>
            ))}
          </select>
        </div>
        <div className="col">
          <label className="form-label">Quantity</label>
          <input
            type="text"
            className="form-control"
            placeholder="Qty"
            value={qty}
            onChange={(e) => setQty(e.target.value)}
          />
        </div>
      </div>
      <div className="row" style={{ paddingTop: "10px" }}>
        <div className="col">
          <button className="btn btn-primary" onClick={calculatePrice}>
            Calculate
          </button>
        </div>
      </div>
      <div className="row" style={{ paddingTop: "10px" }}>
        <div className="col">
          <h3>
            Price: <span>{price}</span>
          </h3>
        </div>
      </div>
    </div>
  );
}
