import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Input from './component/pricecalc/Input';

function App() {
  return (
    <BrowserRouter>
      <div>
        <Routes>
          <Route path="/price-calc/input" element={<Input />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
