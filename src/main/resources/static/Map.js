const API_URL = 'http://localhost:8082/routes';

// ── Map setup ──
const map = L.map('map', { zoomControl: false }).setView([43.818, -91.238], 13);
L.control.zoom({ position: 'bottomright' }).addTo(map);
L.tileLayer('https://{s}.basemaps.cartocdn.com/dark_all/{z}/{x}/{y}{r}.png', {
  attribution: '© OpenStreetMap © CARTO',
  maxZoom: 19
}).addTo(map);

// ── State ──
let routeLayers = {};
let activeId = null;

// ── Load routes ──
async function loadRoutes() {
    const res = await fetch(API_URL);
    if (!res.ok) throw new Error(`HTTP ${res.status}`);
    const routes = await res.json();

    document.getElementById('statusDot').className = 'dot';
    document.getElementById('statusText').textContent = `Connected · ${routes.length} routes`;
    document.getElementById('routeCount').textContent = `${routes.length} routes available`;

    renderSidebar(routes);
    renderMapRoutes(routes);
}

// ── Sidebar ──
function renderSidebar(routes) {
  const list = document.getElementById('routeList');

  list.innerHTML = '';

  routes.forEach(r => {
    console.log('Sidebar card ID:', r.id);
    const card = document.createElement('div');
    card.className = 'route-card';
    card.id = `card-${r.id}`;
    card.innerHTML = `
      <div class="route-name">${r.name || 'Unnamed Route'}</div>
      <div class="route-stats">
        <div class="stat"><span class="stat-label">Distance</span><span class="stat-value">${r.distance != null ? r.distance + ' mi' : '—'}</span></div>
        <div class="stat"><span class="stat-label">Elevation</span><span class="stat-value">${r.ftGain != null ? r.ftGain + ' ft' : '—'}</span></div>
        <div class="stat"><span class="stat-label">Rating</span><span class="stat-value">${r.runnerRating != null ? '★'.repeat(r.runnerRating) : '—'}</span></div>
      </div>
      ${r.surface ? `<span class="badge ${getBadgeClass(r.surface)}">${r.surface}</span>` : ''}
    `;
    card.addEventListener('click', () => selectRoute(r.id));
    list.appendChild(card);
  });
}

function getBadgeClass(surface) {
  const s = surface.toLowerCase();
  if (s.includes('pave')) return 'badge-paved';
  if (s.includes('dirt')) return 'badge-trail';
  if (s.includes('gravel')) return 'badge-gravel';
  return 'badge-default';
}


// ── Map ──
function renderMapRoutes(routes) {
  routes.forEach(r => {
    if (!r.routeGeoJson) return;

      const geo = JSON.parse(r.routeGeoJson);
      const layer = L.geoJSON(geo, {
        style: { color: '#4ade80', weight: 3, opacity: 0.7 },
        onEachFeature: (feature, featureLayer) => {
          featureLayer.on('click', () => selectRoute(r.id));
        }
      }).addTo(map);

      routeLayers[r.id] = layer;
      console.log('Layer stored with ID:', r.id);
  });

  const allLayers = Object.values(routeLayers);
  if (allLayers.length > 0) {
    map.fitBounds(L.featureGroup(allLayers).getBounds().pad(0.1));
  }
}

// ── Select route ──
function selectRoute(id) {
  console.log('selectRoute called with ID:', id);
  console.log('Available layer IDs:', Object.keys(routeLayers));

  // Deselect previous
  if (activeId !== null) {
    document.getElementById(`card-${activeId}`)?.classList.remove('active');
    routeLayers[activeId]?.setStyle({ color: '#4ade80', weight: 3, opacity: 0.7 });
  }

  activeId = id;

  // Highlight sidebar card
  const card = document.getElementById(`card-${id}`);
  card?.classList.add('active');
  card?.scrollIntoView({ behavior: 'smooth', block: 'nearest' });

  // Highlight map layer
  const layer = routeLayers[id];
  if (layer) {
    layer.setStyle({ color: '#ffffff', weight: 5, opacity: 1 });
    map.fitBounds(layer.getBounds().pad(0.15));
  }
}

loadRoutes();