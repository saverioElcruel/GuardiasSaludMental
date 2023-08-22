import "./App.css";
import Footer from "./components/public/Footer";
import Main from "./components/public/Main"; 
import Navbar from "./components/public/Navbar";
import { Route, Routes, BrowserRouter as Router } from "react-router-dom";
import Detail from "./components/public/Detail";
import UserForm from "./components/public/UserForm";
import Posiciones from "./components/public/Posiciones";

function App() {
  return (
      <div>
      <Router>
      <Navbar />
      <Routes>
          <Route exact path="/" element={<Main/>}  />
          <Route exact path="/user-form" element={<UserForm />}  />
          <Route path="/detail/:id" element={<Detail />}  />
          <Route path="/posiciones" element={<Posiciones />}  />
      </Routes>
      </Router>
      <Footer />
      </div>
  );
}

export default App;