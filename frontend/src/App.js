import logo from './logo.svg';
import './App.css';
import ButtonAppBar from './molecules/ButtonAppBar';
import PopulationChart from './organisms/PopulationChart';

function App() {
  return (
    <div className="App">
       <ButtonAppBar/> 
       <PopulationChart />
    </div>
  );
}

export default App;
