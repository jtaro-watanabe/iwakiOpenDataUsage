import logo from './logo.svg';
import './App.css';
import ButtonAppBar from './molecules/ButtonAppBar';
import PopulationChart from './organisms/PopulationChart';
import MarketTransactionQuantityChart from './organisms/MarketTransactionQuantityChart';
import WifiMap from './organisms/WifiMap';
import DentalMap from './organisms/DentalMap';

import {
  BrowserRouter as Router,
  Switch,
  Route
} from 'react-router-dom';

function App() {
  return (
    <div className="App">
       <ButtonAppBar/>
       <Router>
        <Switch>
          <Route path="/transaction/">
            <MarketTransactionQuantityChart />
          </Route>
          <Route path="/population/">
            <PopulationChart />
          </Route>
          <Route path="/map/wifi/">
            <WifiMap />
          </Route>
          <Route path="/map/dental/">
            <DentalMap />
          </Route>
        </Switch>
       </Router>
    </div>
  );
}

export default App;
