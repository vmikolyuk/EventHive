
import maplibregl, {Map as MapType} from 'maplibre-gl';
import React, {FC, useEffect, useRef, useState} from 'react';
import './Map.css';
import 'maplibre-gl/dist/maplibre-gl.css';
// @ts-ignore
import styles from './Map.css.json';

const Map: FC = () => {
  const mapContainer = useRef(null);
  const map = useRef<null | MapType>(null);
  const [lng] = useState(-74.5);
  const [lat] = useState(40);
  const [zoom] = useState(14);

  useEffect(() => {
    if (map.current) {
      return;
    }

    map.current = new maplibregl.Map({
      container: mapContainer.current!,
      style: 'https://demotiles.maplibre.org/style.json', // stylesheet location
      center: [lng, lat], // starting position [lng, lat]
      zoom: zoom // starting zoom
    });
  });

  return (
    <div className={styles.MapWrapper}>
      <div
        className={styles.Map}
        ref={mapContainer}
      />
    </div>
  );
};

export default Map;
