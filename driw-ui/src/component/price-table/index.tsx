import { NavLink } from "react-router-dom";

interface PriceTableProps {
  match: any;
  itemName: string;
  location: any;
}
export default function PriceTable(props: PriceTableProps) {
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
      <div className="row" style={{paddingTop: "20px"}}>
        <h3> Price List </h3>
        <table className="table">
          <thead>
            <tr>
              <th scope="col">Quantity</th>
              <th scope="col">Price</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>Mark</td>
              <td>Otto</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  );
}
