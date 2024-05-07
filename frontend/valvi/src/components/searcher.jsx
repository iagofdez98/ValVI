import React, { useState } from 'react';
import "./searcher.css";
import { Form, ListGroup } from 'react-bootstrap';

function SearchableList({ games }) {
  const [searchTerm, setSearchTerm] = useState("");
  const [showSearch, setShowSearch] = useState(false);

  const filteredItems = games.filter(item =>
    item.name.toLowerCase().includes(searchTerm.toLowerCase())
  );

  const toggleSearch = () => {
    if(searchTerm.length > 0) {
    setShowSearch(false);
    } else {
      setShowSearch(!showSearch);
    }
  }

  const handleClick = (item) => {
    window.location.href = `/games/${item.id}`;
  };

  return (
    <div style={{ position: "relative" }}>
      <Form.Control
        type="text"
        placeholder="Buscar..."
        value={searchTerm}
        onChange={(e) => setSearchTerm(e.target.value)}
        onClick={toggleSearch}
      />
      {showSearch && (
        <div style={{ position: "absolute", top: "100%", left: 0, zIndex: 100, backgroundColor: "white", width: "100%", boxShadow: "0 4px 8px rgba(0,0,0,0.1)" }}>
          <ListGroup>
            {filteredItems.map((item, index) => (
              <ListGroup.Item className='list-group-item' key={index} onClick={() => handleClick(item)}>{item.name}</ListGroup.Item>
            ))}
          </ListGroup>
        </div>
      )}
    </div>
  );
}

export default SearchableList;
