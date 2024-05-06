import React, { useEffect } from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import HomeContent from './components/home/home-content';
import GameDetail from './components/detail/game-detail';
import Footer from './components/app-footer';
import Header from './components/app-header';
import { getGamesByUser } from './services/rating-service';
import LoadingPage from './components/auth/auth';
import { getAuthToken, getUsername } from './api_helper';

const App = () => {
  const [games, setGames] = React.useState([])

  useEffect(() => {
    getGamesByUser().then((data) => {
      setGames(data)
    }).catch((error) => {
      console.log(error)
    });
  }, []);

  return (
    <div className='bg-dark text-light'>
      <Router>
        <Header username={getUsername()}/>
        {getAuthToken() != null ?
          <Routes>
            <Route path="/home" element={<HomeContent games={games}/>} />
            <Route path="/game/:id" element={<GameDetail />} />
            <Route path='/games' element={<HomeContent className='mt-4'><HomeContent games={games} listOnlyGames={true}/></HomeContent>} />
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
