import React, { useState } from "react";
import axios from "axios";
import "./page.css";

const UrlShortener = () => {
  const [longUrl, setLongUrl] = useState("");
  const [shortCode, setShortCode] = useState("");
  const [isLoading, setIsLoading] = useState(false);

  const backendBaseUrl = "http://localhost:8080";

  const handleShortenClick = async (event) => {
    event.preventDefault();
    setIsLoading(true);
    setShortCode("");

    try {
      const response = await axios.post(
        `${backendBaseUrl}/shorten`,
        { originalUrl: longUrl },
        {
          headers: { "Content-Type": "application/json" },
          responseType: "text",
        }
      );

      const generatedShortCode = response.data;
      setShortCode(generatedShortCode);
      setLongUrl("");
    } catch (error) {
      console.error("Error creating short URL:", error);
      alert("Failed to shorten the URL. Please try again.");
    } finally {
      setIsLoading(false);
    }
  };

  const handleShortUrlClick = async () => {
    if (!shortCode) return;

    try {
      const response = await axios.get(`${backendBaseUrl}/${shortCode}`);
      const { originalUrl } = response.data;

      if (originalUrl) {
        window.open(originalUrl, "_blank");
      } else {
        alert("Original URL not found for this short code.");
      }
    } catch (error) {
      console.error("Error fetching original URL:", error);
      alert("Unable to find original URL. The short URL may be invalid.");
    }
  };

  return (
    <div className="url-shortener-container">
      <h2 className="heading">URL Shortener</h2>

      <form onSubmit={handleShortenClick} className="url-form">
        <input
          type="url"
          value={longUrl}
          onChange={(e) => setLongUrl(e.target.value)}
          placeholder="Enter a long URL"
          required
          className="url-input"
        />

        <button type="submit" className="shorten-button" disabled={isLoading}>
          {isLoading ? "Shortening..." : "Shorten"}
        </button>
      </form>

      {shortCode && (
        <div className="result-section">
          <p>Your shortened URL:</p>
          <button onClick={handleShortUrlClick} className="short-url-link" >
            {`${backendBaseUrl}/${shortCode}`}
          </button>
        </div>
      )}
    </div>
  );
};

export default UrlShortener;
