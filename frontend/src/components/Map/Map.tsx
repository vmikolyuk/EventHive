// @ts-ignore
import './Map.css';
import React, {FC, useEffect, useRef, useState} from 'react';
import styles from './Map.css.json';
import 'maplibre-gl/dist/maplibre-gl.css';
import maplibreGl, {Map as MapType} from 'maplibre-gl';
import MapboxLanguage from '@mapbox/mapbox-gl-language';

const Map: FC = () => {
  const mapContainer = useRef(null);
  const map = useRef<null | MapType>(null);
  const [lng] = useState(44.629650);
  const [lat] = useState(33.535667);
  const [zoom] = useState(5);

  useEffect(() => {
    if (map.current) {
      return;
    }

    map.current = new maplibreGl.Map({
      container: mapContainer.current!,
      style: `https://api.maptiler.com/maps/6d0d88cc-ed1b-4caa-86ef-bab2261c4cc1/style.json?key=${process.env.ACCESS_TOKEN_FOR_MAP}`,
      center: [lng, lat], // starting position [lng, lat]
      zoom // starting zoom
    });

    map.current.addControl(new maplibreGl.NavigationControl(), 'top-right');

    const language = new MapboxLanguage();
    map.current.addControl(language);

    new maplibreGl.Marker()
      .setLngLat([12.550343, 55.665957])
      .addTo(map.current);
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
