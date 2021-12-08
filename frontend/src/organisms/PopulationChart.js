import {React , useEffect , useState  } from 'react';
import { Bar } from 'react-chartjs-2';
import axios from 'axios';




function PopulationChart() { 

    const [populationData, setPopulationData] = useState([])

    useEffect(() => {
      axios.get('http://localhost:8080/population/total')
      .then(response =>setPopulationData(response.data.data))
      .catch(error => console.log(error))
      }, [])

    const data1 = [3, 1, 5, 8, 20, 10, 15, 30];
    const data2 = [2, 3, 10, 5, 5, 9, 10, 10];

    const graphData = () => {

      let labels = []

      let tairaData = []
      let onahamaData = []
      let nakosoData = []
      let jobanData = []
      let uchigoData = []
      let yotsukuraData = []
      let tounoData = []
      let ogawaData = []
      let yoshimaData = []
      let miwaData = []
      let tabitoData = []
      let kawamaeData = []
      let hisanohamaData = []

      if(populationData) {
        for (let i = 0; i < populationData.length; i++) {

            let record = populationData[i]

            labels.push(record.yearDate);
            tairaData.push(record.taira);
            onahamaData.push(record.onahama);
            nakosoData.push(record.nakoso);
            jobanData.push(record.joban);
            uchigoData.push(record.uchigo);
            yotsukuraData.push(record.yotsukura);
            tounoData.push(record.touno);
            ogawaData.push(record.ogawa);
            yoshimaData.push(record.yoshima)
            miwaData.push(record.miwa);
            tabitoData.push(record.tabito);
            kawamaeData.push(record.kawamae);
            hisanohamaData.push(record.hisanohama);


        }
      }

      let datasets = [
        {
          label: "平",
          data: tairaData,
          backgroundColor: "rgb(255, 160, 122)",
          order: 1
        },
        {
          label: "田人",
          data: tabitoData,
          backgroundColor: "gb(60, 179, 113)",
          order: 1
        },
        {
          label: "小名浜",
          data: onahamaData,
          backgroundColor: "rgb(0, 191, 255)",
          order: 1
        },
        {
          label: "勿来",
          data: nakosoData,
          backgroundColor: "rgb(143, 188, 139)",
          order: 1
        },
        {
          label: "常磐",
          data: jobanData,
          backgroundColor: "rgb(255, 228, 181)",
          order: 1
        },
        {
          label: "内郷",
          data: uchigoData,
          backgroundColor: "rgb(221, 160, 221)",
          order: 1
        },
        {
          label: "四倉",
          data: yotsukuraData,
          backgroundColor: "rgb(102, 51, 153)",
          order: 1
        },
        {
          label: "遠野",
          data: tounoData,
          backgroundColor: "rgb(0, 250, 154)",
          order: 1
        },
        {
          label: "小川",
          data: ogawaData,
          backgroundColor: "rgb(240, 230, 140)",
          order: 1
        },
        {
          label: "好間",
          data: yoshimaData,
          backgroundColor: "rgb(34, 139, 34)",
          order: 1
        },
        {
          label: "三和",
          data: miwaData,
          backgroundColor: "rgb(0, 0, 128)",
          order: 1
        },
        {
          label: "川前",
          data: kawamaeData,
          backgroundColor: "rgb(147, 112, 219)",
          order: 1
        },
        {
          label: "久ノ浜",
          data: hisanohamaData,
          backgroundColor: "rgb(123, 104, 238)",
          order: 1
        }
      ]
      
      return {
        labels,
        datasets
      }
    }

    const data = {
      
      labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug"],
      datasets: [
        {
          label: "Data1",
          data: data1,
          backgroundColor: "rgba(87, 121, 234, 0.6)",
          borderColor: "rgba(87, 121, 234, 0.6)",
          yAxisID: "bar-stacked",
          order: 1,
        },
        {
          label: "Data2",
          data: data2,
          backgroundColor: "rgba(18, 200, 150, 0.6)",
          borderColor: "rgba(18, 200, 150, 0.6)",
          yAxisID: "bar-stacked",
          order: 1,
        },
       ],
    }
    
    const options = {
      scales: {
        xAxes: [
          {
            scaleLabel: {
              display: true,
              labelString: "Months",
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

export default PopulationChart;