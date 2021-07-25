import React , {Component} from 'react';
import CanvasJSChart from "./assests/canvasjs.react";

var openValues = [{
    x : 0.2222 ,
    y : new Date()
},{
    x : 0.2221 ,
    y : new Date()
}];

var closeValues = [{
    x : 0.1222 ,
    y : new Date()
},{
    x : 0.1221 ,
    y : new Date()
}];

class LineChart extends Component {

    constructor(props) {
        super(props);
        this.updateChart = this.updateChart.bind(this);
    }

    componentDidMount(){
        setInterval(this.updateChart,1000);
    }

    updateChart(){
        //this.chart.render();
        console.log("update line chart");
    }

    render() {

        const options = {
            title: {
                text: 'Stock Options'
            },
            axisY: {
                includeZero: false ,
                valueFormatString: '0.##0' ,
                title: 'Price in (USD)'
            },
            axisX: {
                valueFormatString: 'HH:mm'
            },
            data: [{
                type: 'line' ,
                name: 'Open Value' ,
                showInLegend: true ,
                yValueFormatString: '0.##0' ,
                xValueFormatString: 'HH:mm' ,
                dataPoints: openValues
            },{
                type: 'line' ,
                name: 'Close Value' ,
                showInLegend: true ,
                yValueFormatString: '0.##0' ,
                xValueFormatString: 'HH:mm' ,
                dataPoints: closeValues
            }]
        }

        return (
            <div>
                <h1>Acompanhamento de cotação</h1>
                <CanvasJSChart options={options} onRef={ ref => this.chart = ref }/>
            </div>
        );
    }

}

export default LineChart;