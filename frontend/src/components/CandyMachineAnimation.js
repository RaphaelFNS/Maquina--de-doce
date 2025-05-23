import React, { useState, useEffect } from "react";
import "../styles/CandyMachineAnimation.css";

const CandyMachineAnimation = ({ saldo, doceEscolhido }) => {
  const [showCoin, setShowCoin] = useState(false);
  const [showCandy, setShowCandy] = useState(false);
  const [showPopup, setShowPopup] = useState(false);

  useEffect(() => {
 
  }, [saldo, doceEscolhido]);

  const insertCoin = () => {
    setShowCoin(true);
    setTimeout(() => {
      setShowCoin(false);
      setShowCandy(true);
    }, 1500);
  };

  const removeCandy = () => {
    setShowCandy(false);
    setShowPopup(true);

    setTimeout(() => {
      setShowPopup(false);
    }, 5000);
  };

  return (
    <div className="machine-container">
      {showPopup && (
        <div className="candy-popup">
          <h2>Doce Retirado!</h2>
          <h3>🍬</h3>
        </div>
      )}

      <div className={`machine ${showPopup ? "blurred" : ""}`}>
        {showCoin && <div className="coin"></div>}
        {showCandy && <div className="candy"></div>}
      </div>

      {}
      <button
        className="btn btn-success mt-3"
        onClick={insertCoin}
      >
        Finalizar compra
      </button>

      {showCandy && (
        <button className="btn btn-danger mt-3" onClick={removeCandy}>
          Retirar Doce
        </button>
      )}
    </div>
  );
};

export default CandyMachineAnimation;