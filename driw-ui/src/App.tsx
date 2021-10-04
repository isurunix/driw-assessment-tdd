import React from "react";
import { BrowserRouter, Redirect, Route, Switch } from "react-router-dom";
import "./App.css";
import Header from "./component/header";
import ItemList from "./component/item-list";
import PriceCalculator from "./component/price-calculator";
import PriceTable from "./component/price-table";

function App() {
  return (
    <BrowserRouter>
      <Header></Header>
      <Switch>
        <Route exact path="/shop" component={ItemList} />
        <Route exact path="/calculator" component={PriceCalculator} />
        <Route exact path="/price-table/:id" component={PriceTable} />
        <Redirect from="/" to="/shop" />
      </Switch>
    </BrowserRouter>
  );
}

export default App;
