import React, { useState, useEffect } from 'react';
import '/Users/Daniel/Documents/ITchangas/prodeApp/prode/src/App.css'

function Example() {
  // Declara una nueva variable de estado, la cual llamaremos “count”
  const [count, setCount] = useState(0);
  return (
    <div>
      <p>You clicked {count} times</p>
      <button onClick={() => setCount(count + 1)}>
        Click me
      </button>
    </div>
  );
}

function Ejemplo(){
  const [luz, setLuz] = useState('ON');
  return(
    <div class="div">
      <p>{luz}</p>
      <button onClick={() => setLuz((luz=='ON')?'OFF':'ON')}>
        ON/OFF
      </button>
    </div>
  )
}

export default Ejemplo;