import {React , useEffect , useState  } from 'react';
import { Bar } from 'react-chartjs-2';
import axios from 'axios';

function MarketTransactionQuantityChart() { 

    const [transactionQuantity, setQuantityData] = useState([])

    useEffect(() => {
      axios.get('http://localhost:8080/market/transaction')
      .then(response =>setQuantityData(response.data.data))
      .catch(error => console.log(error))
      }, [])

    const graphData = () => {

      let labels = []

      let vegetable = []
      let fruit = []
      let processedBirdEgg = []
      let fruitAndVegetableSectionTotal = []
      let freshFish = []
      let frozen = []
      let saltDriedProducts = []
      let fisheriesDepartmentTotal = []
      let flowerPart = []

      if(transactionQuantity) {
        for (let i = 0; i < transactionQuantity.length; i++) {

            let record = transactionQuantity[i]

            labels.push(record.year);
            vegetable.push(record.vegetable.quantity);
            fruit.push(record.fruit.quantity);
            processedBirdEgg.push(record.processedBirdEgg.quantity);
            fruitAndVegetableSectionTotal.push(record.fruitAndVegetableSectionTotal.quantity);
            freshFish.push(record.freshFish.quantity);
            frozen.push(record.frozen.quantity);
            saltDriedProducts.push(record.saltDriedProducts.quantity);
            fisheriesDepartmentTotal.push(record.fisheriesDepartmentTotal.quantity);
            flowerPart.push(record.flowerPart.quantity);
        }
      }

      let datasets = [
        {
          label: "野菜",
          data: vegetable,
          backgroundColor: "rgb(255, 160, 122)",
          order: 1
        },
        {
          label: "果実",
          data: processedBirdEgg,
          backgroundColor: "gb(60, 179, 113)",
          order: 1
        },
        {
          label: "鳥卵加工品",
          data: processedBirdEgg,
          backgroundColor: "rgb(0, 191, 255)",
          order: 1
        },
        {
          label: "青果部",
          data: fruitAndVegetableSectionTotal,
          backgroundColor: "rgb(143, 188, 139)",
          order: 1
        },
        {
          label: "鮮魚",
          data: freshFish,
          backgroundColor: "rgb(255, 228, 181)",
          order: 1
        },
        {
          label: "冷凍",
          data: frozen,
          backgroundColor: "rgb(221, 160, 221)",
          order: 1
        },
        {
          label: "塩干加",
          data: saltDriedProducts,
          backgroundColor: "rgb(102, 51, 153)",
          order: 1
        },
        {
          label: "水産物部",
          data: fisheriesDepartmentTotal,
          backgroundColor: "rgb(0, 250, 154)",
          order: 1
        },
        {
          label: "花き部",
          data: flowerPart,
          backgroundColor: "rgb(240, 230, 140)",
          order: 1
        }
      ]
      
      return {
        labels,
        datasets
      }
    }
    const options = {
      scales: {
        xAxes: [
          {
            scaleLabel: {
              display: true,
              labelString: "Year",
             },
             stacked: "true",
          },
         ],
        yAxes: [
          {
            scaleLabel: {
              stacked: false,
              display: true,
              labelString: "Values",
             },
            id: "bar-stacked",
            stacked: "true",
            position: 'right',
          },
         ],
      },
    }

    return (
      <div>
        <Bar data={graphData}
        options={options}
        />

      </div>
    );
}

export default MarketTransactionQuantityChart;