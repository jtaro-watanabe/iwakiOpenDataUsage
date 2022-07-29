import {React , useEffect , useState  } from 'react';
import axios from 'axios';
import {MapContainer, TileLayer, Marker, Popup, Tooltip} from 'react-leaflet';
import "leaflet/dist/leaflet.css";
import icon from "leaflet/dist/images/marker-icon.png";
import iconShadow from "leaflet/dist/images/marker-shadow.png";
import Leaflet from "leaflet";


let DefaultIcon = Leaflet.icon({
  iconUrl: icon,
  shadowUrl: iconShadow,
});
Leaflet.Marker.prototype.options.icon = DefaultIcon;

function DentalMap() { 

    const [dentalMarkers, setDentalMarkers] = useState([]);

    useEffect(() => {
      axios.get('http://localhost:8080/map/dental')
      .then((response) =>{
          let apiResponse = response.data.data
        
          if(apiResponse) {
            
            let dentalMaps = [];
            
            for (let i = 0; i < apiResponse.length; i++) {

              let record = apiResponse[i];

              let dentalResource = {
                coordinates: {
                  lat: record.latitude,
                  lng: record.longitude              
              } ,
              title: record.name
            };

            dentalMaps.push(dentalResource);
           
          }

          setDentalMarkers(dentalMaps);
          
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

          {dentalMarkers.map((marker, index) => (
            <Marker key={index} position={marker.coordinates}>
              <Tooltip>{marker.title}</Tooltip>
            </Marker>
          ))}
        </MapContainer>
      </div>
    );
}

export default DentalMap;