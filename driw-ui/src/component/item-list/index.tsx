import ItemCard from "../item-card";

export default function ItemList() {
  return (
    <div className="container" id="body">
      <div className="col-12">
        <div className="row">
          <ItemCard id={1} cartonPrice={175} name={"Penguin Ears"}></ItemCard>
          <ItemCard id={2} cartonPrice={875} name={"Horseshoe"}></ItemCard>
        </div>
      </div>
    </div>
  );
}
