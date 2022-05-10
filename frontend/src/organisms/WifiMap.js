import {React , useEffect , useState  } from 'react';
import axios from 'axios';
import {MapContainer, TileLayer, Marker, Popup} from 'react-leaflet';
import "leaflet/dist/leaflet.css";
import icon from "leaflet/dist/images/marker-icon.png";
import iconShadow from "leaflet/dist/images/marker-shadow.png";
import Leaflet from "leaflet";


let DefaultIcon = Leaflet.icon({
  iconUrl: icon,
  shadowUrl: iconShadow,
});
Leaflet.Marker.prototype.options.icon = DefaultIcon;

function WifiMap() { 

    const [wifiMarkers, setWifiMarkers] = useState([]);

    useEffect(() => {



      // axios.get('http://localhost:8080/map/wifi')
      // .then((response) =>{setWifiResources(response.data.data)})
      // .catch(error => console.log(error))

      axios.get('http://localhost:8080/map/wifi')
      .then((response) =>{
          let apiResponse = response.data.data
        
          if(apiResponse) {
            
            let wifiMaps = [];
            
            for (let i = 0; i < apiResponse.length; i++) {

              let record = apiResponse[i];

              let wifiResource = {
                coordinates: {
                  lat: record.latitude,
                  lng: record.longitude              
              } ,
              title: record.name
            };

            wifiMaps.push(wifiResource);
           
          }

          setWifiMarkers(wifiMaps);
          
        }
        
      })
      .catch(error => console.log(error))
      
      

    }, []);

    const position = [37.05487743, 140.8881944];
  
    return (
      <div>
        <MapContainer center={position} zoom="13" style={{height: "100vh", width: "100vw"}}>
          <TileLayer
            attribution='&copy; <a href="https://maps.gsi.go.jp/development/ichiran.html">国土地理院</a>'
            url="https://cyberjapandata.gsi.go.jp/xyz/std/{z}/{x}/{y}.png"
          />

          {wifiMarkers.map((marker, index) => (
            <Marker key={index} position={marker.coordinates}>
              <Popup>{marker.title}</Popup>
            </Marker>
          ))}
        </MapContainer>
      </div>
    );
}

export default WifiMap;