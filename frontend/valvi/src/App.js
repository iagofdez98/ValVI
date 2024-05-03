import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './components/home/home';
import GameDetail from './components/detail/game-detail';
import Footer from './components/app-footer';
import Header from './components/app-header';

const App = () => {
  return (
    <div className='bg-dark text-light'>
      <Router>
        <Header/>
        <Routes>
          <Route path="/home" element={<Home />} />
          <Route path="/game/:id" element={<GameDetail />} />
        </Routes>
        <Footer/>
      </Router>
    </div>
  );
};

export default App;
