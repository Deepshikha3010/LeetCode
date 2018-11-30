public class Vector2D implements Iterator<Integer> {
  private Iterator<List<Integer>> rowIter;
  private Iterator<Integer> colIter;
  
  public Vector2D(List<List<Integer>> vec2d) {
      this.rowIter = vec2d.iterator();
      this.colIter = Collections.emptyIterator();
  }

  @Override
  public Integer next() {
      return colIter.next();
  }

  @Override
  public boolean hasNext() {
      while ((colIter == null || !colIter.hasNext()) && rowIter.hasNext()) {
          colIter = rowIter.next().iterator();
      }
      return colIter != null && colIter.hasNext();
  }
}

/**
* Your Vector2D object will be instantiated and called as such:
* Vector2D i = new Vector2D(vec2d);
* while (i.hasNext()) v[f()] = i.next();
*/