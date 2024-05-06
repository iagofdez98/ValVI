import React, { useEffect } from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import HomeContent from './components/home/home-content';
import GameDetail from './components/detail/game-detail';
import Footer from './components/app-footer';
import Header from './components/app-header';
import GameList from './components/home/game-list';
import { getGames } from './services/videogame-service';
import { Container } from 'react-bootstrap';
import LoadingPage from './components/auth/auth';
import { getAuthToken } from './api_helper';

const App = () => {
  const [games, setGames] = React.useState([])

  useEffect(() => {
    getGames().then((data) => {
      setGames(data)
    }).catch((error) => {
      console.log(error)
    });
  }, []);

  return (
    <div className='bg-dark text-light'>
      <Router>
        <Header/>
        {getAuthToken() != null ?
          <Routes>
            <Route path="/home" element={<HomeContent games={games}/>} />
            <Route path="/game/:id" element={<GameDetail />} />
            <Route path='/games' element={<Container className='mt-4'><GameList games={games}/></Container>} />
          </Routes>
          :
          <LoadingPage/>
        }
        <Footer/>
      </Router>
    </div>
  );
};

export default App;
