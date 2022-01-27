import logo from './logo.svg';
import './App.css';
import ButtonAppBar from './molecules/ButtonAppBar';
import PopulationChart from './organisms/PopulationChart';
import MarketTransactionQuantityChart from './organisms/MarketTransactionQuantityChart';

function App() {
  return (
    <div className="App">
       <ButtonAppBar/> 
       <MarketTransactionQuantityChart />
    </div>
  );
}

export default App;
