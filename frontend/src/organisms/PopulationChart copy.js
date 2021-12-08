import React from 'react';
import { Bar } from 'react-chartjs-2';

function PopulationChart() { 

    const data1 = [3, 1, 5, 8, 20, 10, 15, 30];
    const data2 = [2, 3, 10, 5, 5, 9, 10, 10];
    
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
        <Bar data={data}
        options={options}
        />
      </div>
    );
}

export default PopulationChart;