import { NavLink } from "react-router-dom";

interface ItemCardProps {
  id: number;
  name: string;
  cartonPrice: number;
}

export default function ItemCard(props: ItemCardProps) {
  return (
    <div className="col-2">
      <div className="card">
        <div className="card-body">
          <h5 className="card-title">{props.name}</h5>
          <h6 className="card-subtitle mb-2 text-muted">
            {props.cartonPrice} per Carton
          </h6>
          <NavLink
            href="#"
            className="card-link"
            to={{
              pathname: "/price-table/" + props.id,
              state: { name: props.name },
            }}
          >
            View
          </NavLink>
        </div>
      </div>
    </div>
  );
}
