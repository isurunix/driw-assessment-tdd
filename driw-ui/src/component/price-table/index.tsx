import axios from "axios";
import { useEffect, useState } from "react";
import { NavLink } from "react-router-dom";

interface PriceTableProps {
  match: any;
  itemName: string;
  location: any;
}

interface ItemPrice {
  itemId: number;
  quantity: number;
  price: number;
}

export default function PriceTable(props: PriceTableProps) {
  const [itemId] = useState(props.match.params.id);
  const [prices, setPrices] = useState(Array<ItemPrice>());

  useEffect(() => {
    axios
      .get("http://localhost:8000/item/" + itemId + "/price-list")
      .then((response) => {
        setPrices(response.data);
      })
      .catch((err) => {
        console.error(err);
        setPrices([]);
      });
  }, [itemId]);

  return (
    <div className="container" id="body">
      <div className="row">
        <div className="breadcrumbs">
          <span>
            <NavLink to="/shop"> Shop </NavLink>
          </span>{" "}
          &gt; {props.location.state.name ? props.location.state.name : "Item"}
        </div>
      </div>
      <div className="row" style={{ paddingTop: "20px" }}>
        <h3> Price List </h3>
        <table className="table">
          <thead>
            <tr>
              <th scope="col">Quantity</th>
              <th scope="col">Price</th>
            </tr>
          </thead>
          <tbody>
            {prices.map((itemPrice) => (
              <tr key={itemPrice.quantity}>
                <td>{itemPrice.quantity}</td>
                <td>{itemPrice.price}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
