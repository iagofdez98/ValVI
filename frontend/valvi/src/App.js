import React, { useEffect } from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import HomeContent from './components/home/home-content';
import GameDetail from './components/detail/game-detail';
import Footer from './components/app-footer';
import Header from './components/app-header';
import { getGames } from './services/videogame-service';
import LoadingPage from './components/auth/auth';
import { getAuthToken, getUsername } from './api_helper';
import UserGames from './components/user-games';
import ReviewList from './components/review/review-list';
import ListDetails from './components/lists/lists-detail';

const App = () => {
  const [games, setGames] = React.useState([])

  useEffect(() => {
    getGames().then((data) => {
      setGames(data)
    }).catch((error) => {
      console.log(error)
    });
  }, []);

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
      {getAuthToken() != null ? <>
        <Header username={getUsername()} games={games}/>
          <Routes>
            <Route path="/home" element={<HomeContent/>} />
            <Route path="/game/:id" element={<GameDetail games={games} />} />
            <Route path='/games' element={<UserGames className='mt-4'></UserGames>} />
            <Route path='/reviews' element={<ReviewList className='margin-container mt-4' lastReviews={1000}></ReviewList>} />
            <Route path='/lists' element={<ListDetails games={games}/>}/>
          </Routes>
        <Footer/></>
        : <LoadingPage/>}
      </Router>
    </div>
  );
};

export default App;
